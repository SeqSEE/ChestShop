package com.creeperface.nukkitx.chestshop.economy

import cn.nukkit.Player
import xyz.cryptechcraft.cryptoconomyapi.CryptoconomyAPI
import java.math.BigDecimal
import java.math.RoundingMode

class EconomyAPIInterface : EconomyInterface {

    private val economy: CryptoconomyAPI = CryptoconomyAPI.getInstance()

    override fun hasMoney(p: String, amount: String) = economy.myMoney(p).compareTo(BigDecimal(amount).setScale(8, RoundingMode.HALF_EVEN)) >= 0


    override fun hasMoney(p: Player, amount: String) = economy.myMoney(p).compareTo(BigDecimal(amount).setScale(8, RoundingMode.HALF_EVEN)) >= 0

    override fun subtractMoney(p: String, amount: String) {
        economy.reduceMoney(p, BigDecimal(amount).setScale(8, RoundingMode.HALF_EVEN).toPlainString())
    }

    override fun addMoney(p: String, amount: String) {
        economy.addMoney(p, BigDecimal(amount).setScale(8, RoundingMode.HALF_EVEN).toPlainString())
    }
}