package lejazzy.skycore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import lejazzy.skycore.gui.GuiTEST;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("test")
public class TESTCommand extends BaseCommand {

    private final GuiTEST guiTEST = new GuiTEST();

    @Default
    public void onTest(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande ne peut être utilisée que par des joueurs.");
            return;
        }
    }

    @Subcommand("help")
    @CommandPermission("test.help")
    public void onHelp(Player player) {
        player.sendMessage("§7*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        player.sendMessage(" ");
        player.sendMessage("§aCommande disponibles : ");
        player.sendMessage("/test gui §7>> §fSert a ouvrir le menu de test ----");
        player.sendMessage("§7*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    @Subcommand("gui")
    @CommandAlias("test.gui")
    public void onGui(Player player) {
        // Ouvre le menu
        player.openInventory(guiTEST.createInventory());
    }



}
