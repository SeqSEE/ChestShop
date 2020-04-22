package com.creeperface.nukkitx.chestshop.economy

import cn.nukkit.Player

/**
 * @author CreeperFace
 */
interface EconomyInterface {

    fun hasMoney(p: Player, amount: String) = hasMoney(p.name, amount)

    /**
     * isn't called directly but can be used for name based economy systems
     */
    fun hasMoney(p: String, amount: String): Boolean

    fun subtractMoney(p: Player, amount: String) = subtractMoney(p.name, amount)

    /**
     * isn't called directly but can be used for name based economy systems
     */
    fun subtractMoney(p: String, amount: String)

    fun addMoney(p: Player, amount: String) = addMoney(p.name, amount)

    fun addMoney(p: String, amount: String)

    //    @JvmDefault
    fun take(p: Player, amount: String): Boolean {
        if (!hasMoney(p, amount)) {
            return false
        }

        subtractMoney(p, amount)
        return true
    }

    //    @JvmDefault
    fun transfer(from: String, to: String, amount: String) {
        subtractMoney(from, amount)
        addMoney(to, amount)
    }
}