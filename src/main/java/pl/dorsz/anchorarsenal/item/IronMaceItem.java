
package pl.dorsz.anchorarsenal.item;

import java.util.function.Consumer;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;

import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;

import software.bernie.geckolib.renderer.GeoRenderProvider;
import software.bernie.geckolib.util.GeckoLibUtil;

import pl.dorsz.anchorarsenal.client.renderer.IronMaceRenderer;

public class IronMaceItem extends MaceItem implements GeoItem {

    private static final RawAnimation IDLE =
            RawAnimation.begin().thenLoop(
                    "animation.anchor_arsenal.iron_mace.idle"
            );

    private static final RawAnimation ATTACK =
            RawAnimation.begin().thenPlay(
                    "animation.anchor_arsenal.iron_mace.attack"
            );

    private static final RawAnimation SLAM =
            RawAnimation.begin().thenPlay(
                    "animation.anchor_arsenal.iron_mace.slam"
            );

    private final AnimatableInstanceCache cache =
            GeckoLibUtil.createInstanceCache(this);

    public IronMaceItem(Properties properties) {
        super(properties);

        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void registerControllers(
            AnimatableManager.ControllerRegistrar controllers
    ) {
        controllers.add(
                new AnimationController<>(
                        this,
                        "main_controller",
                        0,
                        state -> state.setAndContinue(IDLE)
                )
                .triggerableAnim("attack", ATTACK)
                .triggerableAnim("slam", SLAM)
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createGeoRenderer(
            Consumer<GeoRenderProvider> consumer
    ) {
        consumer.accept(new GeoRenderProvider() {

            private IronMaceRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (renderer == null) {
                    renderer = new IronMaceRenderer();
                }

                return renderer;
            }
        });
    }

    @Override
    public boolean hurtEnemy(
            ItemStack stack,
            LivingEntity target,
            LivingEntity attacker
    ) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (attacker.level() instanceof ServerLevel serverLevel) {

            String animation = MaceItem.canSmashAttack(attacker)
                    ? "slam"
                    : "attack";

            triggerAnim(
                    attacker,
                    GeoItem.getOrAssignId(stack, serverLevel),
                    "main_controller",
                    animation
            );
        }

        return result;
    }
}
