/*
 * This file is part of HuskChat, licensed under the Apache License 2.0.
 *
 *  Copyright (c) William278 <will27528@gmail.com>
 *  Copyright (c) contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package net.william278.huskchat.bungeecord.listener;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;
import net.william278.huskchat.bungeecord.HuskChatBungee;
import net.william278.huskchat.bungeecord.player.BungeePlayer;
import net.william278.huskchat.listener.PlayerListener;
import net.william278.huskchat.message.ChatMessage;
import net.william278.huskchat.player.PlayerCache;

public class BungeeListener extends PlayerListener implements Listener {

    private static final HuskChatBungee plugin = HuskChatBungee.getInstance();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChat(ChatEvent e) {
        if (e.isCommand() || e.isProxyCommand() || e.isCancelled()) {
            return;
        }

        final ProxiedPlayer player = (ProxiedPlayer) e.getSender();
        boolean shouldCancel = new ChatMessage(PlayerCache.getPlayerChannel(player.getUniqueId()),
                BungeePlayer.adaptCrossPlatform(player), e.getMessage(), plugin).dispatch();
        if (shouldCancel) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChangeServer(ServerSwitchEvent e) {
        final String server = e.getPlayer().getServer().getInfo().getName();
        final BungeePlayer player = BungeePlayer.adaptCrossPlatform(e.getPlayer());
        handlePlayerSwitchServer(player, server, plugin);
    }

}
