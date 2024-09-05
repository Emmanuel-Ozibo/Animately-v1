package com.example.animatelyapp.utils

import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.Item
import com.example.animatelyapp.ui.components.Shipment
import com.example.animatelyapp.ui.components.StaggeredItem
import com.example.animatelyapp.ui.components.Status
import com.example.animatelyapp.ui.components.avaliablevehicles.ShipmentVehicle
import com.example.animatelyapp.ui.components.shipments.ShipmentHistory

object DummyData {
    fun getAvailableVehicles(): List<ShipmentVehicle> =
        listOf(
            ShipmentVehicle(
                name = "Cargo Freight",
                subTitle = "Reliable",
                iconRes = R.drawable.img_cargo_ship,
            ),
            ShipmentVehicle(
                name = "Truck Freight",
                subTitle = "Reliable",
                iconRes = R.drawable.img_cargo_truck,
            ),
            ShipmentVehicle(
                name = "Air Freight",
                subTitle = "International",
                iconRes = R.drawable.img_air_freight,
            ),
        )

    fun getShipments(): List<Shipment> =
        listOf(
            Shipment(
                title = "Summer Linen Jacket",
                detail = "#NFHJHDHD3675678489 \u2022 Barcelona \u2192 Paris",
            ),
            Shipment(
                title = "Tarpared Jeans",
                detail = "#NFHJHDHD3675678489 \u2022 Barcelona \u2192 Nigeria",
            ),
            Shipment(
                title = "Macbook Pro M2",
                detail = "#NFHJHDHD3675678489 \u2022 Paris \u2192 London",
            ),
            Shipment(
                title = "Office Desk",
                detail = "#NFHJHDHD3675678489 \u2022 London \u2192 Dubai",
            ),
        )

    fun getStaggeredItems(): List<StaggeredItem<String>> =
        listOf(
            StaggeredItem(value = "Documents", selected = false, title = "Document"),
            StaggeredItem(value = "Glass", selected = false, title = "Glass"),
            StaggeredItem(value = "Liquid", selected = false, title = "Liquid"),
            StaggeredItem(value = "Food", selected = false, title = "Food"),
            StaggeredItem(value = "Electronic", selected = false, title = "Electronic"),
            StaggeredItem(value = "Products", selected = false, title = "Products"),
            StaggeredItem(value = "Others", selected = false, title = "Others"),
        )

    fun getShipmentHistory() =
        ShipmentHistory(
            id = 0,
            status = Status.IN_PROGRESS,
            title = "Arriving today",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023",
        )

    fun getShipmentHistories(): List<ShipmentHistory> =
        listOf(
            ShipmentHistory(
                id = 0,
                status = Status.IN_PROGRESS,
                title = "Arriving today1",
                description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
                price = "\$2000 USD",
                date = "Sept 20, 2023",
            ),
            ShipmentHistory(
                id = 1,
                status = Status.LOADING,
                title = "Arriving today2",
                description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
                price = "\$2000 USD",
                date = "Sept 20, 2023",
            ),
            ShipmentHistory(
                id = 2,
                status = Status.PENDING,
                title = "Arriving today3",
                description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
                price = "\$2000 USD",
                date = "Sept 20, 2023",
            ),
            ShipmentHistory(
                id = 3,
                status = Status.IN_PROGRESS,
                title = "Arriving today4",
                description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
                price = "\$2000 USD",
                date = "Sept 20, 2023",
            ),
            ShipmentHistory(
                id = 4,
                status = Status.IN_PROGRESS,
                title = "Arriving today5",
                description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
                price = "\$2000 USD",
                date = "Sept 20, 2023",
            ),
            ShipmentHistory(
                id = 5,
                status = Status.PENDING,
                title = "Arriving today6",
                description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
                price = "\$2000 USD",
                date = "Sept 20, 2023",
            ),
        )

    fun getFilterOptions(): List<Item> =
        listOf(
            Item(
                title = "All",
                count = "30",
                isSelected = true,
                status = Status.ALL
            ),
            Item(
                title = "Completed",
                count = "30",
                isSelected = false,
                status = Status.COMPLETED
            ),
            Item(
                title = "In Progress",
                count = "10",
                isSelected = false,
                status = Status.IN_PROGRESS
            ),
            Item(
                title = "Pending",
                count = "10",
                isSelected = false,
                status = Status.PENDING
            ),
            Item(
                title = "Loading",
                count = "10",
                isSelected = false,
                status = Status.LOADING
            ),
            Item(
                title = "Cancelled",
                count = "10",
                isSelected = false,
                status = Status.CANCELLED
            ),
        )
}
