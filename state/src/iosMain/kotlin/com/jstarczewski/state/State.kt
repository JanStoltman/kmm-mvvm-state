package com.jstarczewski.state

import kotlin.reflect.KProperty

actual open class State<T : Any>(
    private var initialValue: T,
    private var objectWillChange: () -> Unit = {}
) {

    actual open operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return initialValue
    }

    actual open operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        initialValue = value
        objectWillChange()
    }
}