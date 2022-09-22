/*
 * Back-WS-SN1: Back end of FoxFood.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.gaetandev.backwssn1.manager.managers;

import com.gaetandev.backwssn1.data.MenuData;
import com.gaetandev.backwssn1.manager.Manager;
import com.gaetandev.backwssn1.manager.ManagerHandler;

public final class MenuManager extends Manager {
    public MenuManager(final ManagerHandler handler) {
        super(handler);

        this.addMenu(11245, "First Day", "Vegetable Wok", "wok-vege.jpg");
        this.addMenu(11246, "Second Day", "Pasta Bolognese", "pastebolo.jpg");
        this.addMenu(11247, "Third Day", "Turkye Rice", "rizdine.webp");
        this.addMenu(11248, "Fourth Day", "Mushroom Omelet", "omelette.webp");
        this.addMenu(11249, "Fifth Day", "Pizza", "pizza.webp");
    }

    private void addMenu(final int id, final String day, final String name, final String image) {
        final String link = "https://api-ws-sn1.gaetandev.fr/images/";

        this.handler.getMainSpring().getMenus().put(name,
                new MenuData(String.valueOf(id), day, name, link + image));

    }
}
