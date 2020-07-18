package com.yxmcute.codelabs.databinding

import android.view.View
import androidx.lifecycle.ViewModel

/**
 * @author Li Jun
 * @date 2019/7/24 9:53
 * @filename  Bean
 * @description  TODO
 */
class SimleViewModel : ViewModel() {
  val name = "jun"
  val lastName = "li"
  var likes = 0
    private set

  fun onLike() {
    likes++
  }

  val popularity: Popularity
    get() {
      return when {
        likes > 9 -> Popularity.STAR
        likes > 4 -> Popularity.POPULAR
        else -> Popularity.STAR
      }
    }

}

enum class Popularity {
  NORMAL,
  POPULAR,
  STAR
}


data class User(var name: String? = null, var age: String)

class Presenter {

  fun onClick(view: View) {}

  fun onClickButton(view: View, user: User): Boolean {
    return true
  }
}