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

package com.gaetandev.backwssn1.manager;

import com.gaetandev.backwssn1.MainSpring;
import com.gaetandev.backwssn1.manager.managers.MenuManager;
import com.gaetandev.backwssn1.manager.managers.SavingManager;
import com.gaetandev.backwssn1.manager.managers.ThreadManager;

public class ManagerHandler {
    private final MainSpring mainSpring;
    private final ThreadManager threadManager;
    private final SavingManager savingManager;
    private final MenuManager menuManager;


    public ManagerHandler(final MainSpring mainSpring) {
        this.mainSpring = mainSpring;
        this.threadManager = new ThreadManager(this);
        this.savingManager = new SavingManager(this);
        this.menuManager = new MenuManager(this);
    }

    public ThreadManager getThreadManager() {
        return this.threadManager;
    }

    public SavingManager getSavingManager() {
        return this.savingManager;
    }

    public MenuManager getMenuManager() {
        return this.menuManager;
    }

    public MainSpring getMainSpring() {
        return this.mainSpring;
    }
}
