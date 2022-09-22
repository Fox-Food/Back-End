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

package com.gaetandev.backwssn1.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class UserData implements Serializable {
    private String email, password, firstName, secondName, address;
    private final List<MenuData> likedMenu;
    private final List<MenuData> favoriteMenu;

    public UserData(final String email, final String password) {
        this.email = email;
        this.password = password;
        this.likedMenu = new LinkedList<>();
        this.favoriteMenu = new LinkedList<>();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getAddress() {
        return this.address;
    }

    public List<MenuData> getLikedMenu() {
        return this.likedMenu;
    }

    public List<MenuData> getFavoriteMenu() {
        return this.favoriteMenu;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public void setAddress(final String address) {
        this.address = address;
    }
}
