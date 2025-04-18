package lejazzy.skycore.api;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class commandRegister {

    private final Plugin plugin;
    private final PaperCommandManager commandManager;

    /**
     * Initialise le système d'enregistrement des commandes avec PaperCommandManager.
     *
     * @param plugin Instance du plugin Bukkit
     */
    public CommandRegister(Plugin plugin) {
        this.plugin = plugin;
        this.commandManager = new PaperCommandManager(plugin);
    }

    /**
     * Enregistre une seule commande.
     *
     * @param command Commande à enregistrer
     */
    public final void registerCommand(@NotNull BaseCommand command) {
        Objects.requireNonNull(command, "La commande ne peut pas être null");

        try {
            commandManager.registerCommand(command);
            System.out.println("Commande enregistrée : " + command.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement de la commande : " + command.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    /**
     * Enregistre plusieurs commandes en une seule fois.
     *
     * @param commands Liste des commandes à enregistrer
     */
    public final void registerCommands(@NotNull Collection<BaseCommand> commands) {
        Objects.requireNonNull(commands, "La liste des commandes ne peut pas être null");

        for (BaseCommand command : commands) {
            if (command == null) {
                System.out.println("Une commande null a été détectée et ignorée.");
                continue;
            }
            registerCommand(command);
        }
    }

    /**
     * Méthode de compatibilité pour supporter les varargs.
     *
     * @param commands Liste des commandes sous forme de varargs
     */
    public final void registerCommands(@NotNull BaseCommand... commands) {
        registerCommands(Arrays.asList(commands));
    }
}
