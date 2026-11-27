
package pl.dorsz.anchorarsenal.registry;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import pl.dorsz.anchorarsenal.AnchorArsenal;
import pl.dorsz.anchorarsenal.item.IronMaceItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AnchorArsenal.MOD_ID);

    private static ItemAttributeModifiers ironMaceAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                Item.BASE_ATTACK_DAMAGE_ID,
                                10.0,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(
                                Item.BASE_ATTACK_SPEED_ID,
                                -3.4,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    public static final DeferredItem<IronMaceItem> IRON_MACE =
            ITEMS.register("iron_mace", () ->
                    new IronMaceItem(
                            new Item.Properties()
                                    .stacksTo(1)
                                    .durability(500)
                                    .attributes(ironMaceAttributes())
                    )
            );
}
