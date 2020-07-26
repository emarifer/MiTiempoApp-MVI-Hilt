package com.marin.mitiempoapp.business.domain.util

/**
 * Created by Enrique Marín on 25/07/20.
 */

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity
}