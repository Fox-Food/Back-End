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

import com.gaetandev.backwssn1.manager.Manager;
import com.gaetandev.backwssn1.manager.ManagerHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class ThreadManager extends Manager {
    private final ExecutorService threadPool;
    private final ScheduledExecutorService threadScheduledPool;

    public ThreadManager(final ManagerHandler handler) {
        super(handler);

        this.threadPool =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.threadScheduledPool =
                Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public ScheduledExecutorService getThreadScheduledPool() {
        return this.threadScheduledPool;
    }
}
