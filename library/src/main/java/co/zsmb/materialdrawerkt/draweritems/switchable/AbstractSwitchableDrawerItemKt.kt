package co.zsmb.materialdrawerkt.draweritems.switchable

import android.widget.CompoundButton
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.AbstractSwitchableDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

abstract class AbstractSwitchableDrawerItemKt : BaseDescribeableDrawerItemKt() {

    /* Builder basics */

    private lateinit var item: AbstractSwitchableDrawerItem<*>

    protected fun setItem(item: AbstractSwitchableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    /* AbstractSwitchableDrawerItem methods */

    /**
     * Whether the drawer item is selectable.
     *
     * Wraps the withCheckable function.
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("selectable"),
            message = "Use the selectable property instead.")
    var checkable: Boolean
        get() = nonReadable()
        set(value) {
            item.withCheckable(value)
        }

    /**
     * Whether the drawer item's switch is currently in its "on" state.
     *
     * Wraps the withChecked and isChecked functions.
     */
    var checked: Boolean
        get() = item.isChecked
        set(value) {
            item.withChecked(value)
        }

    /**
     * Adds an event [handler] to the drawer item that's called when the switch's state is changed.
     *
     * Wraps the withOnCheckedChangeListener function.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isChecked True if the switch is now in an "on" state
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("onSwitchChanged(handler)"),
            message = "Use onSwitchChanged instead.")
    fun onCheckedChange(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isChecked: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the switch's state is changed.
     *
     * Replacement for onCheckedChange.
     *
     * Wraps the withOnCheckedChangeListener function.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isEnabled True if the switch is now in an "on" state
     */
    fun onSwitchChanged(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Alternative to the 3 parameter onToggleChanged method, to be used when you don't need all its parameters.
     *
     * Wraps the withOnCheckedChangeListener function.
     *
     * @param isEnabled True if the switch is now in an "on" state
     */
    fun onToggled(handler: (isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener { _, _, isEnabled ->
            handler(isEnabled)
        }
    }

    /**
     * Whether the drawer item's switch can be toggled by the user.
     *
     * Wraps the withSwitchEnabled and isSwitchEnabled functions.
     */
    var switchEnabled: Boolean
        get() = item.isSwitchEnabled
        set(value) {
            item.withSwitchEnabled(value)
        }

}
