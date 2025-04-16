package lejazzy.skycore.api;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ListenerRegisters {

    private final Plugin plugin;

    /**
     * Initialise le système d'enregistrement des listeners avec le plugin.
     *
     * @param plugin Instance du plugin Bukkit
     */
    public ListenerRegisters(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Enregistre un seul listener.
     *
     * @param listener Listener à enregistrer
     */
    public final void registerListener(@NotNull Listener listener) {
        Objects.requireNonNull(listener, "Le listener ne peut pas être null");

        try {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
            System.out.println("Listener enregistré : " + listener.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement du listener : "
                    + listener.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Enregistre plusieurs listeners en une seule fois.
     *
     * @param listeners Liste des listeners à enregistrer
     */
    public final void registerListeners(@NotNull Collection<? extends Listener> listeners) {
        Objects.requireNonNull(listeners, "La liste des listeners ne peut pas être null");

        for (Listener listener : listeners) {
            if (listener == null) {
                System.out.println("Un listener null a été détecté et ignoré.");
                continue;
            }
            registerListener(listener);
        }
    }

    /**
     * Méthode de compatibilité pour supporter les varargs.
     *
     * @param listeners Liste des listeners sous forme de varargs
     */
    public final void registerListeners(@NotNull Listener... listeners) {
        registerListeners(Arrays.asList(listeners));
    }
}
