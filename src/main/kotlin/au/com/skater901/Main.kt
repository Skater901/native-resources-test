package au.com.skater901

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val uiVersion = "5.17.11"

            val uiBasePath = "/META-INF/resources/webjars/swagger-ui/$uiVersion"

            val fullPath = "$uiBasePath/swagger-ui.css"

            println("Full path: $fullPath")

            println("Swagger UI swagger-ui.css exists: ${Main::class.java.getResource(fullPath) != null}")
        }
    }
}