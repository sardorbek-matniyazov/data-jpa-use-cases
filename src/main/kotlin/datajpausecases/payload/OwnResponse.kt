package datajpausecases.payload

import org.springframework.http.ResponseEntity

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
data class OwnResponse(
    var message: String,
    var status: Int,
    val data: MutableMap<String, Any> = mutableMapOf(),
) {
    // default response objects
    companion object {
        fun onSuccess() = OwnResponse("Success", 200)
        fun onFailed() = OwnResponse("Failed", 400)
        fun onNotFound() = OwnResponse("Not found", 404)
        fun onCreated() = OwnResponse("Created", 201)
    }

    // default setter functions
    fun setMessage(message: String): OwnResponse = apply { this.message = message }
    fun setStatus(status: Int): OwnResponse = apply { this.status = status }
    fun addData(key: String, value: Any): OwnResponse = apply {
        data[key] = value
    }

    // default response functions
    fun handleResponse(): ResponseEntity<Any> = ResponseEntity.status(status).body(this)
}
