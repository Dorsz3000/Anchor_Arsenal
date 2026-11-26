
package pl.dorsz.anchorarsenal.client.renderer;

import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.model.GeoModel;

import pl.dorsz.anchorarsenal.AnchorArsenal;
import pl.dorsz.anchorarsenal.item.IronMaceItem;

public class IronMaceModel extends GeoModel<IronMaceItem> {

    @Override
    public ResourceLocation getModelResource(IronMaceItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                AnchorArsenal.MOD_ID,
                "geo/iron_mace.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(IronMaceItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                AnchorArsenal.MOD_ID,
                "textures/item/iron_mace.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(IronMaceItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                AnchorArsenal.MOD_ID,
                "animations/iron_mace.animation.json"
        );
    }
}
