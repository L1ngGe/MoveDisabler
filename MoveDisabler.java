package today.candy.features.modules.impl.exploit;

import today.candy.event.annotations.EventTarget;
import today.candy.event.impl.network.PacketSendEvent;
import today.candy.features.modules.Category;
import today.candy.features.modules.Module;
import today.candy.utils.network.PacketUtils;

public class MoveDisabler extends Module {
    public MoveDisabler() {
        super("MoveDisabler",Category.EXPLOIT,"Move Disabler");
    }
}
