package com.osg.practicemvicomposenav.data

data class PharmacyElement(
    val exceededTransferLimit: Boolean,
    val features: List<Feature>,
    val fields: List<Field>,
    val geometryType: String,
    val spatialReference: SpatialReference,
    val objectIDFieldName: String,
    val hasZ: Boolean,
    val hasM: Boolean
)

data class Feature(
    val attributes: Attributes,
    val geometry: Geometry
)

data class Attributes(
    val objectid: Long,
    val addr: String,
    val x: Long,
    val y: Long
)

data class Geometry(
    val x: Double,
    val y: Double
)

data class Field(
    val name: String,
    val type: String,
    val alias: String,
    val length: Long? = null
)

data class SpatialReference(
    val wkid: Long,
    val latestWkid: Long
)
