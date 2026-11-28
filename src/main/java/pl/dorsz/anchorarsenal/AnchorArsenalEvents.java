
package pl.dorsz.anchorarsenal;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;

import pl.dorsz.anchorarsenal.registry.ModItems;

@EventBusSubscriber(
        modid = AnchorArsenal.MOD_ID,
        bus = EventBusSubscriber.Bus.GAME
)
public class AnchorArsenalEvents {

    @SubscribeEvent
    public static void onCriticalHit(CriticalHitEvent event) {
        if (event.isCriticalHit()
                && event.getEntity().getMainHandItem()
                .is(ModItems.IRON_MACE.get())) {

            event.setDamageMultiplier(2.0F);
        }
    }
}
