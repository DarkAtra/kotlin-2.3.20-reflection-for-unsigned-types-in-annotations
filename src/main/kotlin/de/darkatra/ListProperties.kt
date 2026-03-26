package de.darkatra

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE)
annotation class ListProperties(
	val size: UInt = 0u
)
