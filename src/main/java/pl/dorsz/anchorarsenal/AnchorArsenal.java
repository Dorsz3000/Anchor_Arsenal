
package pl.dorsz.anchorarsenal;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import pl.dorsz.anchorarsenal.registry.ModItems;

@Mod(AnchorArsenal.MOD_ID)
public class AnchorArsenal {

    public static final String MOD_ID = "anchorarsenal";

    public AnchorArsenal(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
    }
}
