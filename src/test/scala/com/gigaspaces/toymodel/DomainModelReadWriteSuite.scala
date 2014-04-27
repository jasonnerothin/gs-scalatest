/*
 * Copyright [2014] [Jason Nerothin]
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.gigaspaces.toymodel

import com.gigaspaces.GsI10nSuite
import com.gigaspaces.query.{ISpaceQuery, IdQuery}
import com.gigaspaces.toymodel.Salary
import org.scalatest.ConfigMap
import scala.sys.SystemProperties
import java.util.NoSuchElementException
import com.gigaspaces.client.{ChangeModifiers, ChangeResult, ChangeSet}
import java.util.concurrent.Future
import com.gigaspaces.async.AsyncFutureListener

/** Created by IntelliJ IDEA.
  * User: jason
  * Date: 2/27/14
  * Time: 3:20 PM
  */
class DomainModelReadWriteSuite extends GsI10nSuite {

  override def beforeEach(configMap: ConfigMap): Unit = {
    assume(spaceContents() == 0)
  }

  ignore("scalatest works (negative control)") {
    assert(1 + 1 + 1 === 2)
  }

  test("scalatest works (positive control)") {
    assert(1 + 1 === 2)
  }

  test("read write Employee")(pending)

  test("read write JobDescription")(pending)

  ignore("read write Salary") {

    val id = 32
    val salary = Salary(id, 100000)
    val lc = gigaSpace.write(salary)

    val readBack = gigaSpace.readById(new IdQuery(classOf[Salary], id))

    assert(readBack === salary)

  }

  ignore("salary asyncChange(ISpaceQuery, ChangeSet)") {
    val spaceQuery: ISpaceQuery[Salary] = makeSpaceQuery()
    val changeSet: ChangeSet = makeChangeSet()
    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(spaceQuery, changeSet)
  }

  def makeSpaceQuery(): ISpaceQuery[Salary] = {
    null
  }

  def makeChangeSet(): ChangeSet[Salary] = {
    null
  }

  ignore("salary asyncChange(Salary, ChangeSet)") {
    val salary: Salary = makeSalary()
    val changeSet: ChangeSet = makeChangeSet()
    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(salary, changeSet)
  }

  def makeSalary(): Salary = {
    null
  }

  ignore("salary asyncChange(ISpaceQuery, ChangeModifiers, AsyncFutureListener[ChangeResult[Salary]])") {

    val spaceQuery = makeSpaceQuery()
    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()

    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS


    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers0, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers1, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers2, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers3, listener)
    // verify(listener.gotPinged)

  }

  def makeAsyncFutureListener(): AsyncFutureListener[ChangeResult[Salary]] = {
    null
  }

  ignore("salary asyncChange(ISpaceQuery, ChangeModifiers, Long, AsyncFutureListener[ChangeResult[Salary]])") {

    val spaceQuery = makeSpaceQuery()
    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()
    val timeout: Long = 39
    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers0, timeout, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers1, timeout, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers2, timeout, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers3, timeout, listener)
    // verify(listener.gotPinged)

    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers4, timeout, listener)
    // verify(listener.gotPinged)

  }

  ignore("salary asyncChange(Salary, ChangeSet[Salary], ChangeModifiers)") {

    val salary: Salary = makeSalary()
    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()

    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(salary, changeSet, listener)

  }

  ignore("salary asyncChange( ChangeSet[Salary], AsyncFutureListener[ChangeResult[Salary]])") {

    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()

    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, listener)

  }

  ignore("salary asyncChange( ChangeSet[Salary], ChangeModifiers, Long, AsyncFutureListener[ChangeResult[Salary]])") {

    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()
    val timeout: Long = 39

    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, changeModifiers0, timeout, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers1, timeout, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers2, timeout, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers3, timeout, listener)
    // verify(listener.gotPinged)

  }

  ignore("salary asyncChange(ChangeSet[Salary], Long)") {

    val changeSet = makeChangeSet()
    val timeout: Long = 39

    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, timeout)

  }

  ignore("salary asyncChange(ChangeSet[Salary], Long, AsyncFutureListener[ChangeResult[Salary]])") {

    val changeSet = makeChangeSet()
    val timeout: Long = 39
    val listener = makeAsyncFutureListener()

    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, timeout, listener)

  }

  ignore("salary asyncChange(ChangeSet[Salary], Long, AsyncFutureListener[ChangeResult[Salary]])") {

    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()
    val timeout: Long = 39

    val result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, timeout, listener)

  }

  ignore("salary asyncChange(ChangeSet[Salary], ChangeModifiers, AsyncFutureListener[ChangeResult[Salary]])") {

    val changeSet = makeChangeSet()
    val listener = makeAsyncFutureListener()

    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, changeModifiers0, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers0, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers1, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers2, listener)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers3, listener)
    // verify(listener.gotPinged)

  }

  ignore("salary asyncChange(ChangeSet[Salary], ChangeModifiers)") {

    val changeSet = makeChangeSet()
    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(changeSet, changeModifiers0)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers0)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers1)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers2)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(changeSet, changeModifiers3)
    // verify(listener.gotPinged)

  }

  ignore("salary asyncChange(ISpaceQuery[Salary], ChangeSet[Salary], ChangeModifiers)") {

    val spaceQuery: ISpaceQuery[Salary] = makeSpaceQuery()
    val changeSet = makeChangeSet()
    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers0)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers1)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers2)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers3)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers4)
    // verify(listener.gotPinged)

  }

  ignore("salary asyncChange(ISpaceQuery[Salary], ChangeSet[Salary], Long, ChangeModifiers)") {

    val spaceQuery = makeSpaceQuery()
    val changeSet = makeChangeSet()
    val timeout: Long = 23
    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(spaceQuery, changeSet, timeout, changeModifiers0)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, timeout, changeModifiers1)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, timeout, changeModifiers2)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, timeout, changeModifiers3)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, timeout, changeModifiers4)

  }

  ignore("salary asyncChange(Salary, ChangeSet[Salary], ChangeModifiers, Long)") {

    val salary: Salary = makeSalary()
    val changeSet = makeChangeSet()
    val timeout: Long = 23
    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(salary, changeSet, changeModifiers0, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(salary, changeSet, changeModifiers0, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(salary, changeSet, changeModifiers1, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(salary, changeSet, changeModifiers2, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(salary, changeSet, changeModifiers3, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(salary, changeSet, changeModifiers4, timeout)
    // verify(listener.gotPinged)

  }

  ignore("salary asyncChange(ISpaceQuery[Salary], ChangeSet[Salary], ChangeModifiers, Long"){

    val spaceQuery = makeSpaceQuery()
    val changeSet = makeChangeSet()
    val timeout: Long = 23
    val changeModifiers0 = ChangeModifiers.MEMORY_ONLY_SEARCH
    val changeModifiers1 = ChangeModifiers.NONE
    val changeModifiers2 = ChangeModifiers.ONE_WAY
    val changeModifiers3 = ChangeModifiers.RETURN_DETAILED_RESULTS

    var result: Future[ChangeResult[Salary]] = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers0, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers1, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers2, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers3, timeout)
    // verify(listener.gotPinged)
    result = gigaSpace.asyncChange(spaceQuery, changeSet, changeModifiers4, timeout)
    // verify(listener.gotPinged)

  }

}