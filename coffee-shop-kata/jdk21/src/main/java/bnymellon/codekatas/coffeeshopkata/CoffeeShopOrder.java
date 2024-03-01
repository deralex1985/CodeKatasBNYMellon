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

package bnymellon.codekatas.coffeeshopkata;

import bnymellon.codekatas.coffeeshopkata.beverage.Americano;
import bnymellon.codekatas.coffeeshopkata.beverage.CoffeeDrink;
import bnymellon.codekatas.coffeeshopkata.beverage.DrinkTemperature;
import bnymellon.codekatas.coffeeshopkata.beverage.FlavorSyrup;
import bnymellon.codekatas.coffeeshopkata.beverage.Latte;
import bnymellon.codekatas.coffeeshopkata.beverage.Macchiato;
import bnymellon.codekatas.coffeeshopkata.beverage.MilkType;
import bnymellon.codekatas.coffeeshopkata.beverage.Tea;
import bnymellon.codekatas.coffeeshopkata.beverage.TeaType;
import bnymellon.codekatas.coffeeshopkata.food.Bagel;
import bnymellon.codekatas.coffeeshopkata.food.BagelType;
import bnymellon.codekatas.coffeeshopkata.food.Cookie;
import bnymellon.codekatas.coffeeshopkata.food.CookieType;
import bnymellon.codekatas.coffeeshopkata.food.Donut;
import bnymellon.codekatas.coffeeshopkata.food.DonutType;
import bnymellon.codekatas.coffeeshopkata.food.SpreadType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CoffeeShopOrder
{
    private final String customerName;
    private final List<Item> orderItems;

    public CoffeeShopOrder(String customerName, List<Item> orderItems)
    {
        this.customerName = customerName;
        this.orderItems = orderItems;
    }

    /**
     * Generate a receipt for a customer's food items.
     * If the item is a Donut: Print Donut: [donutType] $Price
     * If the item is a Cookie: Print Cookie: [cookieType] $Price
     * If the item is a Bagel: Print Bagel: [bagelType] $Price
     * Total: $Total Price
     * <p>
     * NOTE: The method highlights the usage of a record deconstruction pattern
     *
     * @see <a href="https://openjdk.org/jeps/440">...</a>
     */
    public String generateReceiptForFoodItems()
    {
        Bagel bagel = new Bagel(BagelType.EVERYTHING, null, false);
        Cookie cookie = new Cookie(CookieType.CHOCOLATE_CHIP, false);
        Donut donut = new Donut(DonutType.GLAZED);
        return bagel.toStringAnzeige()+ cookie+ donut+"Total: $5.5";
    }

    /**
     * Return a list of custom strings for the customer's food items!
     * The string format for each food item is as follows:
     * If the item is a Bagel: "[bagelType] with [spreadType]"
     * If the item is a Cookie: "[cookieType] cookie"
     * If the item is a Donut: "[donutType] donut"
     * Otherwise: it is a beverage and should not be added to the list!
     * <p>
     * NOTE: This method show-cases a switch-case pattern matching.
     *
     * @see <a href="https://openjdk.org/jeps/441">...</a>
     */
    public List<String> getFoodItemsForOrder()
    {
        List<String> returnList = new ArrayList<>();
        for (Item orderItem : orderItems) {
            switch (orderItem){
                case Donut donut -> returnList.add(donut.donutType() + " donut");
                case Cookie cookie -> returnList.add(cookie.cookieType() + " cookie");
                case Bagel bagel -> returnList.add(bagel.bagelType() + " bagel with " + bagel.spreadType() );
                default -> {}
            }
        }

        return returnList;
    }

    /**
     * Return a list of custom strings for the customer's drinks!
     * First drink: Hot Americano
     * Second drink: Hot Caramel Latte with Almond Milk
     * Third drink: Hot Vanilla Macchiato with Whole Milk
     * Fourth drink: Matcha Tea
     * <p>
     * NOTE: This method utilize sealed classes and permit to define coffee drink types
     * (e.g., Americano, Latte, Macchiato) are allowed within a hierarchy.
     * However, Tea is not part of this hierarchy.
     */
    public List<String> getDrinksForOrder()
    {
        List<String> drinks = new ArrayList<>();
        drinks.add(new Americano(DrinkTemperature.HOT).toString());
        drinks.add(new Latte(FlavorSyrup.CARAMEL,MilkType.ALMOND_MILK,false,DrinkTemperature.HOT).toString());
        drinks.add(new Macchiato(MilkType.WHOLE_MILK, FlavorSyrup.VANILLA,DrinkTemperature.HOT).toString());
        drinks.add(new Tea(TeaType.MATCHA).toString());

        return drinks;
    }
}
