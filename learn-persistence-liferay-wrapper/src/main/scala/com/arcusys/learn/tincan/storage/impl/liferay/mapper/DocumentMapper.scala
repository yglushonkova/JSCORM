package com.arcusys.learn.tincan.storage.impl.liferay.mapper

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument
import com.arcusys.learn.tincan.model.{ OtherContent, JSONContent, Document }
import org.joda.time.DateTime

object DocumentMapper {
  def map(entity: LFTincanLrsDocument) = {
    Document(entity.getDocumentId,
      new DateTime(entity.getUpdate),
      entity.getContent,
      entity.getContentType match {
        case JSONContent.name  => JSONContent
        case OtherContent.name => OtherContent
        case _                 => throw new Exception("Unknown Document content type")
      }
    )
  }
}
