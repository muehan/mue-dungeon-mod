package server.dungeon.map.listeners;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class UseEntityEventListener {
    
    public void Register() {
        // UseEntityCallback.EVENT.register(
        //     (PlayerEntity player, World world, Hand hand, Entity entity, /* Nullable */ EntityHitResult hitResult) -> {

        //         System.out.println("asdf");

        // });
    }

}
