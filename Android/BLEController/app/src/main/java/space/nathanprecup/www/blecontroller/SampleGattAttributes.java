/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package space.nathanprecup.www.blecontroller;

import java.util.HashMap;

/**
 * This class includes a small subset of standard GATT attributes for demonstration purposes.
 */
public class SampleGattAttributes {
    private static HashMap<String, String> attributes = new HashMap<>();
    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";

    static {
        // Device information service.
        attributes.put("00001800-0000-1000-8000-00805f9b34fb", "Device Information Service");
        // Device information service characteristics.
        attributes.put("00002a00-0000-1000-8000-00805f9b34fb", "Device Name");
        attributes.put("00002a01-0000-1000-8000-00805f9b34fb", "Appearance");

        // Camera slide service
        attributes.put("624e957f-cb42-4cd6-bacc-84aeb898f69b", "Motorized Camera Slide Service");
        attributes.put("d9768c38-327b-11e6-ac61-9e71128cae77", "Initialize Slide");
        attributes.put("e4c937b3-7f6d-41f9-b997-40c561f4453b", "Trigger Sequence");
        attributes.put("df342b03-53f9-43b4-acb6-62a63ca0615a", "Current Status");
        attributes.put("789d7f74-3263-11e6-ac61-9e71128cae77", "Interval Length");
        attributes.put("99b1602c-3263-11e6-ac61-9e71128cae77", "Exposure Length");
        attributes.put("9ff71f74-4606-478e-9a1c-506497d0ac81", "Number of shots taken");
        attributes.put("f6653e8c-327d-11e6-ac61-9e71128cae77", "Number of shots requested");
        attributes.put("bb891e48-3267-11e6-ac61-9e71128cae77", "Length of slider travel");
        attributes.put("da9f46dc-32a7-11e6-ac61-9e71128cae77", "Error Code");
        attributes.put("9aabd615-7705-4bf0-b1f5-36073912a203", "Slide axis PWM zero value");

        // Camera slide service characteristics

        // Sample Characteristics.
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}
