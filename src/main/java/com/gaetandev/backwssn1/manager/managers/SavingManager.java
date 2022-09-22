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

import com.gaetandev.backwssn1.MainSpring;
import com.gaetandev.backwssn1.data.UserData;
import com.gaetandev.backwssn1.manager.Manager;
import com.gaetandev.backwssn1.manager.ManagerHandler;

import java.io.*;
import java.util.Map;

public final class SavingManager extends Manager {
    private final MainSpring mainSpring;

    public SavingManager(final ManagerHandler handler) {
        super(handler);

        this.mainSpring = handler.getMainSpring();
        this.loadUsers();
    }

    public void saveAll() {
        this.handler.getThreadManager().getThreadPool().execute(this::saveUsers);
    }

    private void saveUsers() {
        try {
            final FileOutputStream fileOut =
                    new FileOutputStream("./users.foxfood");
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this.mainSpring.getUsers());
            out.close();
            fileOut.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        try {
            final FileInputStream fileIn = new FileInputStream("./users.foxfood");
            final ObjectInputStream in = new ObjectInputStream(fileIn);
            this.mainSpring.setUsers((Map<String, UserData>) in.readObject());
            in.close();
            fileIn.close();
        } catch (final Exception ignored) {

        }
    }
}
