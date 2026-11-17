package pl.dorsz.anchorarsenal;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import java.util.List;

@Mod(AnchorArsenal.MOD_ID)
public final class AnchorArsenal {
    public static final String MOD_ID = "anchorarsenal";
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    private static DeferredItem<Item> weapon(String id, float damage, float speed, float reach) {
        ItemAttributeModifiers attrs = ItemAttributeModifiers.builder()
            .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(ResourceLocation.withDefaultNamespace("base_attack_damage"), damage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, new AttributeModifier(ResourceLocation.withDefaultNamespace("base_attack_speed"), speed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .build();
        return ITEMS.register(id, () -> new WeaponItem(new Item.Properties().stacksTo(1).durability(500).attributes(attrs), reach));
    }

    public static final DeferredItem<Item> IRON_ANCHOR=weapon("iron_anchor",8,-3.3f,2.6f), GOLD_ANCHOR=weapon("gold_anchor",9,-3.1f,2.7f), DIAMOND_ANCHOR=weapon("diamond_anchor",10,-3.2f,2.9f), NETHERITE_ANCHOR=weapon("netherite_anchor",12,-3.2f,3.0f);
    public static final DeferredItem<Item> IRON_SABRE=weapon("iron_sabre",5,-1.8f,0), GOLD_SABRE=weapon("gold_sabre",4,-1.5f,0), DIAMOND_SABRE=weapon("diamond_sabre",6,-1.6f,0), NETHERITE_SABRE=weapon("netherite_sabre",7,-1.6f,0);
    public static final DeferredItem<Item> IRON_MACE=weapon("iron_mace",8,-2.8f,0), GOLD_MACE=weapon("gold_mace",9,-2.6f,0), DIAMOND_MACE=weapon("diamond_mace",10,-2.7f,0), NETHERITE_MACE=weapon("netherite_mace",12,-2.7f,0);
    public static final DeferredItem<Item> STONE_DAGGER=weapon("stone_dagger",2,-0.5f,0), IRON_DAGGER=weapon("iron_dagger",3,-0.5f,0), GOLD_DAGGER=weapon("gold_dagger",2,-0.4f,0), DIAMOND_DAGGER=weapon("diamond_dagger",4,-0.5f,0), NETHERITE_DAGGER=weapon("netherite_dagger",5,-0.5f,0);
    public static final DeferredItem<Item> IRON_GLAIVE=weapon("iron_glaive",7,-2.4f,5), GOLD_GLAIVE=weapon("gold_glaive",7,-2.2f,5), DIAMOND_GLAIVE=weapon("diamond_glaive",9,-2.3f,5), NETHERITE_GLAIVE=weapon("netherite_glaive",10,-2.3f,5);

    public AnchorArsenal(IEventBus modBus) { ITEMS.register(modBus); }

    public static class WeaponItem extends Item {
        private final float reach;
        public WeaponItem(Properties properties, float reach) { super(properties); this.reach = reach; }
        @Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, context, tooltip, flag);
            if (reach > 0) tooltip.add(Component.translatable("tooltip.anchorarsenal.reach", reach));
        }
    }
}
