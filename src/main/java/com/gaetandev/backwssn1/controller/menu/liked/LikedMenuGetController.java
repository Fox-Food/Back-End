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

package com.gaetandev.backwssn1.controller.menu.liked;

import com.gaetandev.backwssn1.MainSpring;
import com.gaetandev.backwssn1.data.UserData;
import com.gaetandev.backwssn1.utils.HashUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin()
@RestController
public class LikedMenuGetController {
    private final MainSpring mainSpring = MainSpring.getInstance();
    private final Map<String, UserData> users = this.mainSpring.getUsers();

    @GetMapping(value = "liked-user-menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object likedmenu(@RequestParam("user") final String user, @RequestParam("pass") final String password) {
        final UserData userData = this.users.get(user);

        if (userData != null && HashUtils.verifyHash(password, userData.getPassword())) {
            return userData.getLikedMenu();
        }

        return null;
    }

}