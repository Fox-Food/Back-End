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

package com.gaetandev.backwssn1;

import com.gaetandev.backwssn1.data.MenuData;
import com.gaetandev.backwssn1.data.UserData;
import com.gaetandev.backwssn1.manager.ManagerHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class MainSpring {
    private static MainSpring instance;
    private Map<String, UserData> users = new ConcurrentHashMap<>();
    private Map<String, MenuData> menus = new ConcurrentHashMap<>();
    private final ManagerHandler managerHandler;

    public MainSpring() {
        instance = this;
        this.managerHandler = new ManagerHandler(this);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainSpring.class, args);
    }

    public Map<String, UserData> getUsers() {
        return users;
    }

    public void setUsers(Map<String, UserData> users) {
        this.users = users;
    }

    public Map<String, MenuData> getMenus() {
        return menus;
    }

    public ManagerHandler getManagerHandler() {
        return managerHandler;
    }

    public static MainSpring getInstance() {
        return instance;
    }
}
