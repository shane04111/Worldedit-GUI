package org.shane0411.worldeditgui.worldeditgui.client;

//import com.mojang.brigadier.CommandDispatcher;
//import com.mojang.brigadier.ParseResults;
//import com.mojang.brigadier.context.CommandContext;
//import com.mojang.brigadier.exceptions.CommandSyntaxException;
//import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
//import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.network.ClientPlayerEntity;
//import net.minecraft.command.CommandSource;
//import org.shane0411.worldeditgui.worldeditgui.util.Message;
//import fi.dy.masa.malilib.command.ClientCommandHandler;

public class Command {
//    public static void registerGUICommand(CommandDispatcher<FabricClientCommandSource> dispatcher) {
//        dispatcher.register(ClientCommandManager
//                .literal("wegui")
//                .executes(Command::ShowGUI));
//    }
//    public static int ShowGUI(CommandContext<FabricClientCommandSource> fabricClientCommandSourceCommandContext) {
//        ClientPlayerEntity player = MinecraftClient.getInstance().player;
//        ParseResults<CommandSource> parseResults = player.networkHandler.getCommandDispatcher().parse("worldedit help", player.getCommandSource());
//        try {
//            player.networkHandler.getCommandDispatcher().execute(parseResults);
//            Message.chat("worldeditgui.start.check.true");
//            return 1;
//        } catch (CommandSyntaxException e) {
//            Message.chat("worldeditgui.start.check.false");
//            return 0;
//        }
//    }
}
