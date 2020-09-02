/**
 * @author Li Jun
 * @date 2019/7/23 19:34
 * @filename  Dep
 * @description
 */
object Dep {
  const val compileSdkVersion = 29
  const val buildToolsVersion = "29.0.3"
  const val minSdkVersion = 21
  const val targetSdkVersion = 29
  const val versionCode = 1
  const val versionName = "1.0"
  const val applicationId = "com.yxmcute.codelabs"

  object Version {

    val constraint = "2.0.0-beta6"

  }

  object JetPack {
    const val startup = "1.0.0-alpha01"
  }

  object Squareup {
    const val leakcanary = "2.4"
  }

  object AndroidX {
    const val startup = "1.0.0-alpha01"
    const val linkage_recyclerview = "1.9.2"

  }

  object Third {
    const val linkage_recyclerview = "1.9.2"
  }

  val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraint}"
  val startup = "androidx.startup:startup-runtime:${JetPack.startup}"

  //https://github.com/square/leakcanary/ https://square.github.io/leakcanary/getting_started/
  val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Squareup.leakcanary}"
  val linkage_recyclerview =
    "com.kunminx.linkage:linkage-recyclerview:${Third.linkage_recyclerview}"

}