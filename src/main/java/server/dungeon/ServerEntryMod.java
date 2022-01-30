package server.dungeon;

import net.fabricmc.api.DedicatedServerModInitializer;
import server.dungeon.player.listeners.ServerPlayConnectionEventListener;


public class ServerEntryMod implements DedicatedServerModInitializer{

    @Override
    public void onInitializeServer() {
    
        System.out.println("Server Mod Initialisation");
        
        new ServerPlayConnectionEventListener().Register();
        
    }
}
