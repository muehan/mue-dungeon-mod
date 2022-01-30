package server.dungeon.player.listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;

public class ServerPlayConnectionEventListener {

    String Path = "players";

    public ServerPlayConnectionEventListener() {
        File directory = new File(Path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void Register() {

        ServerPlayConnectionEvents.JOIN.register(
                (ServerPlayNetworkHandler handler,
                        PacketSender sender,
                        MinecraftServer server) -> {

                    System.out.println("New Player entered Doungen world: " + handler.player.getName().asString());

                    if (isFirstJoin(handler.player)) {
                        givePlayerStartItems(handler.player);
                        createFile(handler.player);
                    }
                });
    }

    private void createFile(
            ServerPlayerEntity player) {
        File file = new File(Path + "/" + player.getUuidAsString());
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("position::x=" + player.getX());
            bw.newLine();
            bw.write("position::y=" + player.getY());
            bw.newLine();
            bw.write("position::z=" + player.getZ());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void givePlayerStartItems(
            ServerPlayerEntity player) {

        ItemStack woodenSwordStack = new ItemStack(Items.WOODEN_SWORD.asItem());
        player.getInventory().insertStack(woodenSwordStack);

        ItemStack woodenShieldStack = new ItemStack(Items.SHIELD.asItem());
        player.getInventory().insertStack(woodenShieldStack);
    }

    private boolean isFirstJoin(
            ServerPlayerEntity player) {

        File playerFile = new File(Path + "/" + player.getUuidAsString());

        if (!playerFile.exists()) {
            return true;
        }

        return false;
    }
}
