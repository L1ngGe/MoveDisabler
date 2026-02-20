package today.candy.features.modules.impl.exploit;

import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import today.candy.event.annotations.EventTarget;
import today.candy.event.impl.network.PacketSendEvent;
import today.candy.features.modules.Category;
import today.candy.features.modules.Module;
import today.candy.utils.network.PacketUtils;

public class MoveDisabler extends Module {

    public MoveDisabler() {
        super("MoveDisabler",Category.EXPLOIT,"Move Disabler");
    }

    @EventTarget
    public void onPacketSend(PacketSendEvent e) {
        if ((e.getPacket() instanceof C0EPacketClickWindow || e.getPacket() instanceof C0DPacketCloseWindow) && mc.thePlayer.isSprinting()) {
            e.setCancelled(true);
            PacketUtils.sendPacket(new C0BPacketEntityAction(mc.thePlayer, C0BPacketEntityAction.Action.STOP_SPRINTING));
            PacketUtils.sendPacketNoEvent(e.getPacket());
            PacketUtils.sendPacket(new C0BPacketEntityAction(mc.thePlayer, C0BPacketEntityAction.Action.START_SPRINTING));
        }
    }
}