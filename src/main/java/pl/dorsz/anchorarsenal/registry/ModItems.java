
package pl.dorsz.anchorarsenal.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.MaceItem;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import pl.dorsz.anchorarsenal.AnchorArsenal;
import pl.dorsz.anchorarsenal.item.IronMaceItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AnchorArsenal.MOD_ID);

    public static final DeferredItem<IronMaceItem> IRON_MACE =
            ITEMS.register("iron_mace", () ->
                    new IronMaceItem(
                            new Item.Properties()
                                    .stacksTo(1)
                                    .durability(500)
                                    .attributes(MaceItem.createAttributes())
                    )
            );
}
