package com.arcusys.learn.tincan.manifest.storage.impl

import com.arcusys.learn.tincan.manifest.storage.TincanPackageStorage
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.tincan.manifest.model.Manifest
import com.arcusys.learn.scorm.manifest.model.{ PackageScopeRule, ScopeType }
import com.arcusys.learn.scorm.manifest.storage.PackageScopeRuleStorage

trait TincanPackageEntityStorage extends TincanPackageStorage with KeyedEntityStorageExt[Manifest] with EntityStorageExt[Manifest] {
  def packageScopeRuleStorage: PackageScopeRuleStorage

  def createAndGetID(entity: Manifest, courseID: Option[Int]): Int = {
    createAndGetID(entity.copy(id = 0, courseID = courseID))
  }

  def getByRefID(refID: Long): Option[Manifest] = {
    getOne("refID" -> refID)
  }

  def getByCourseID(courseID: Option[Int]): Seq[Manifest] = {
    courseID.map(courseID => getByScope(courseID, ScopeType.Site, courseID.toString)).getOrElse(Seq())
  }

  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[Manifest] = {
    getAll("courseID" -> courseID).flatMap(fillManifestWithScopeValues(scope, Option(scopeID)))
  }

  private def fillManifestWithScopeValues(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (Manifest) => Seq[Manifest] = {
    manifest =>
      {
        val scopeRules = packageScopeRuleStorage.getAll(manifest.id, scope, scopeID)
        if (scopeRules.isEmpty) {
          Seq(manifest)
        } else {
          scopeRules.map(fillByScopeRule(manifest))
        }
      }
  }

  private def fillByScopeRule(manifest: Manifest): (PackageScopeRule) => Manifest = {
    scopeRule =>
      manifest.copy(
        visibility = Option(scopeRule.visibility),
        isDefault = scopeRule.isDefault)
  }

  //  def getAllForInstance(courseIDs: List[Int]) : Seq[Manifest] = {
  //    getAll("ids" -> courseIDs)
  //  }

  def setDescriptions(id: Int, title: String, summary: String) {
    modify("id" -> id, "title" -> title, "summary" -> summary)
  }

  def setLogo(id: Int, logo: Option[String]) {
    modify("id" -> id, "logo" -> logo)
  }

  def setAssetRefID(id: Int, refID: Long) {
    modify("id" -> id, "assetRefID" -> refID)
  }

  def getInstanceScopeOnlyVisible(courseIDs: List[Int]) = {
    getAllForInstance(courseIDs).filter(_.visibility.getOrElse(false))
  }

  def getAllForInstance(courseIDs: List[Int]) = {
    getAll("ids" -> courseIDs).flatMap(fillManifestWithScopeValues())
  }

  def getOnlyVisibile(scope: ScopeType.Value, scopeID: String) = {
    packageScopeRuleStorage.getAllVisible(scope, Option(scopeID)).flatMap {
      scopeRule =>
        getOne("packageId" -> scopeRule.packageID).map(fillByScopeRule(_)(scopeRule))
    }
  }

  def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[Manifest] = {
    //Seq()
    getAll("ids" -> courseIDs).flatMap(fillManifestWithScopeValuesWithFilter(scope, Option(scopeID)))
  }

  private def fillManifestWithScopeValuesWithFilter(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (Manifest) => Seq[Manifest] = {
    manifest =>
      {
        val scopeRules = packageScopeRuleStorage.getAll(manifest.id, scope, scopeID)
        if (scopeRules.isEmpty) {
          Seq()
        } else {
          scopeRules.map(fillByScopeRule(manifest))
        }
      }
  }

  override def delete(id: Int) {
    super.delete(id)
    packageScopeRuleStorage.delete(id)
  }
}
