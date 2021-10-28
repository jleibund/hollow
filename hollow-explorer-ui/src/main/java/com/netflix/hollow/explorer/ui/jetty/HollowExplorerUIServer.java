/*
 *  Copyright 2016-2019 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.hollow.explorer.ui.jetty;

import com.netflix.hollow.api.client.HollowClient;
import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;
import com.netflix.hollow.explorer.ui.HollowExplorerUI;

/**
 * @deprecated
 * This class is replaced by {@link com.netflix.hollow.explorer.ui.webserver.HollowExplorerUIServer}
 */
@Deprecated
public class HollowExplorerUIServer extends com.netflix.hollow.explorer.ui.webserver.HollowExplorerUIServer {

    public HollowExplorerUIServer(HollowReadStateEngine readEngine, int port) {
        super( readEngine, port);
    }

    public HollowExplorerUIServer(HollowConsumer consumer, int port) {
        super( consumer, port);
    }

    public HollowExplorerUIServer(HollowClient client, int port) {
        super( client, port);
    }

    public HollowExplorerUIServer(HollowExplorerUI ui, int port) {
        super(ui, port);
    }
}
