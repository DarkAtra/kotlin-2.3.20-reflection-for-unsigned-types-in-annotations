package de.darkatra

import org.junit.jupiter.api.Test
import kotlin.reflect.KProperty
import kotlin.test.assertEquals

class Test {

	@Test
	fun `should get value from annotation`() {

		// obtains the annotation on `list` from the constructor of `Data` - this used to work in <= 2.3.10
		val listPropertiesAnnotation = ::Data.parameters.first().type.annotations.first()

		// obtaining the annotation this way strangely works just like it did in 2.3.10
		// val listPropertiesAnnotation = Data::list.returnType.annotations.first()

		// obtain the getter for `ListProperties#size`
		val sizeGetter = listPropertiesAnnotation.annotationClass.members.filterIsInstance<KProperty<*>>().first().getter

		// attempt to read the value - this should yield 2u
		// instead it throws an InvocationTargetException
		assertEquals(2u, sizeGetter.call(listPropertiesAnnotation))
	}
}
