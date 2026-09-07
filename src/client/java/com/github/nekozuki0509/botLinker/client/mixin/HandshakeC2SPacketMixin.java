package com.github.nekozuki0509.botLinker.client.mixin;

import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(HandshakeC2SPacket.class)
public class HandshakeC2SPacketMixin {

    @ModifyVariable(
            method = "<init>(Ljava/lang/String;ILnet/minecraft/network/NetworkState;)V", 
            at = @At("HEAD"), 
            ordinal = 0, 
            argsOnly = true
    )
    private static String injectBotHint(String address) {
        return address + "_botlinker_";
    }
}