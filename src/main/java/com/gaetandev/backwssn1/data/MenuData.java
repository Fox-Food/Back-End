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

public final class MenuData implements Serializable {
    private final String id, day, name, image;

    public MenuData(final String id, final String day, final String name, final String image) {
        this.id = id;
        this.day = day;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return this.id;
    }

    public String getDay() {
        return this.day;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }
}
