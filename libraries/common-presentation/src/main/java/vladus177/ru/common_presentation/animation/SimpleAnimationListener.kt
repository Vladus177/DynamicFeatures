package vladus177.ru.common_presentation.animation
import android.view.animation.Animation

class SimpleAnimationListener(
    val onRepeat: (Animation?) -> Unit = {},
    val onStart: (Animation?) -> Unit = {},
    val onEnd: (Animation?) -> Unit = {})
    : Animation.AnimationListener {
    override fun onAnimationRepeat(animation: Animation?) {
        onRepeat(animation)
    }

    override fun onAnimationEnd(animation: Animation?) {
        onEnd(animation)
    }

    override fun onAnimationStart(animation: Animation?) {
        onStart(animation)
    }
}