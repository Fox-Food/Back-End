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

import java.util.Map;

@CrossOrigin()
@RestController
public class RegisterController {
    private final MainSpring mainSpring = MainSpring.getInstance();
    private final Map<String, UserData> users = this.mainSpring.getUsers();

    @GetMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean register(@RequestParam("user") final String user, @RequestParam("pass") final String pass,
                            @RequestParam("confirmpass") final String confirmPass) {
        boolean valid = false;

        UserData userData = this.users.get(user);

        if (user != null && pass != null && confirmPass != null) {
            if (userData == null && pass.equals(confirmPass)) {
                userData = new UserData(user, HashUtils.hashString(pass));
                this.users.put(user, userData);
                valid = true;

                this.mainSpring.getManagerHandler().getSavingManager().saveAll();
            }
        }

        return valid;
    }

}
