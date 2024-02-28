package ru.job4j.base.collection

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat


internal class CampaignServiceKtTest {

    @Disabled
    @Test
    fun getDetailedInfo() {
        val date = SimpleDateFormat("dd.MM.yyyy").parse("28.12.2023")
        val list = listOf(
            Campaign("a", Address("Mars"), date),
            Campaign("b", Address("Earth"), date),
        )
        val exp = listOf(
            "Campaign(name=a, address=Address(planet=Mars), created=Thu Dec 28 00:00:00 MSK 2023)",
            "Campaign(name=b, address=Address(planet=Earth), created=Thu Dec 28 00:00:00 MSK 2023)"
        )
        assertThat(getDetailedInfo(list)).containsExactlyElementsOf(exp)
    }
}