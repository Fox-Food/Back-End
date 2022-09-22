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

package com.gaetandev.backwssn1.controller.connection;

import com.gaetandev.backwssn1.MainSpring;
import com.gaetandev.backwssn1.data.UserData;
import com.gaetandev.backwssn1.utils.HashUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class LoginController {

    @GetMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean login(@RequestParam("user") String user, @RequestParam("pass") String pass) {
        boolean valid = false;

        final UserData userData = MainSpring.getInstance().getUsers().get(user);

        if (userData != null) {
            valid = HashUtils.verifyHash(pass, userData.getPassword());
        }

        return valid;
    }

}
