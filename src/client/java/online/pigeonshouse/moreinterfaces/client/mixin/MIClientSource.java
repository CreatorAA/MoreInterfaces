package online.pigeonshouse.moreinterfaces.client.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.chat.Component;
import online.pigeonshouse.moreinterfaces.client.ClientSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientSuggestionProvider.class)
public class MIClientSource implements ClientSource {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Override
    public Minecraft getClient() {
        return minecraft;
    }

    @Override
    public AbstractClientPlayer getPlayer() {
        return minecraft.player;
    }

    @Override
    public ClientLevel getWorld() {
        return minecraft.level;
    }

    public void sendFeedback(Component message) {
        getClient().gui.getChat().addMessage(message);
        getClient().getNarrator().sayNow(message);
    }

    @Override
    public void sendError(Component message) {
        sendFeedback(Component.empty().append(message).withStyle(ChatFormatting.RED));
    }

    @Override
    public void sendSystemMessage(Component component) {
        sendFeedback(Component.empty().append(component).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean acceptsSuccess() {
        return true;
    }

    @Override
    public boolean acceptsFailure() {
        return true;
    }

    @Override
    public boolean shouldInformAdmins() {
        return true;
    }
}
