/*
 * Copyright 2023 The Bank of New York Mellon.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bnymellon.codekatas.coffeeshopkata.beverage;

public record Americano(DrinkTemperature drinkTemperature) implements CoffeeDrink {

    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public int espressoShot() {
        return 1;
    }

    @Override
    public String toString() {
        return drinkTemperature + " " + "Americano";
    }
}
