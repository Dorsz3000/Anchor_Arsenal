
package pl.dorsz.anchorarsenal.client.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import pl.dorsz.anchorarsenal.item.IronMaceItem;

public class IronMaceRenderer extends GeoItemRenderer<IronMaceItem> {

    public IronMaceRenderer() {
        super(new IronMaceModel());
    }
}
