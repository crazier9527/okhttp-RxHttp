package rxhttp.wrapper.parse

import okhttp3.Response
import rxhttp.wrapper.entity.ParameterizedTypeImpl
import java.io.IOException
import java.lang.reflect.Type
import kotlin.reflect.KClass

/**
 * 将Response对象解析成List对象
 * User: ljx
 * Date: 2018/10/23
 * Time: 13:49
 */
open class ListParser<T : Any> : AbstractParser<List<T>> {
    protected constructor() : super()
    constructor(type: Class<T>) : super(type)
    constructor(type: KClass<T>) : super(type.java)

    @Throws(IOException::class)
    override fun onParse(response: Response): List<T> {
        val type: Type = ParameterizedTypeImpl[List::class.java, mType] //拿到泛型类型
        return convert(response, type)
    }
}