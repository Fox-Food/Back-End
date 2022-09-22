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
import com.gaetandev.backwssn1.utils.RandomUtils;

public final class MenuManager extends Manager {
    public MenuManager(ManagerHandler handler) {
        super(handler);

        this.loadMenu();
    }

    private void loadMenu() {
        int id = 11245;
        MenuData menuData =
                new MenuData(String.valueOf(id), "First Day", "Wok Végé", "https://api-ws-sn1.gaetandev.fr/images/wok-vege.jpg");
        handler.getMainSpring().getMenus().put("Wok Végé", menuData);

        id++;

        MenuData menuData2 =
                new MenuData(String.valueOf(id), "Second Day", "Pâtes bolognaises", "https://api-ws-sn1.gaetandev.fr/images/pastebolo.jpg");
        handler.getMainSpring().getMenus().put("Pâtes bolognaises", menuData2);

    }
}
