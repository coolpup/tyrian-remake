/*
 * Copyright (C) 2013-2016 Byron 3D Games Studio (www.b3dgs.com) Pierre-Alexandre (contact@b3dgs.com)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.b3dgs.tyrian.ship;

import com.b3dgs.lionengine.Localizable;
import com.b3dgs.lionengine.Timing;
import com.b3dgs.lionengine.drawable.Sprite;
import com.b3dgs.lionengine.drawable.SpriteTiled;
import com.b3dgs.lionengine.game.feature.FeatureModel;
import com.b3dgs.lionengine.game.feature.FeatureProvider;
import com.b3dgs.lionengine.game.feature.Service;
import com.b3dgs.lionengine.game.feature.Services;
import com.b3dgs.lionengine.game.feature.displayable.Displayable;
import com.b3dgs.lionengine.graphic.Graphic;
import com.b3dgs.lionengine.graphic.Viewer;

/**
 * Ship renderer implementation.
 */
final class ShipRenderer extends FeatureModel implements Displayable
{
    private static final long HIT_TIME = 25L;

    private Sprite hit;
    private final Timing hitTiming = new Timing();
    private SpriteTiled surface;

    @Service private ShipModel model;

    @Service private Viewer viewer;

    /**
     * Create a ship renderer.
     */
    ShipRenderer()
    {
        super();
    }

    /**
     * Show hit effect.
     * 
     * @param localizable The localizable reference.
     * @return <code>true</code> if hit effective, <code>false</code> else.
     */
    public boolean showHit(Localizable localizable)
    {
        if (!hitTiming.isStarted() || hitTiming.elapsed(HIT_TIME * 2))
        {
            hit.setLocation(viewer, localizable);
            hitTiming.restart();
            return true;
        }
        return false;
    }

    @Override
    public void prepare(FeatureProvider provider, Services services)
    {
        super.prepare(provider, services);

        surface = model.getSurface();
        hit = model.getHit();
    }

    @Override
    public void render(Graphic g)
    {
        surface.render(g);
        if (hitTiming.isStarted() && !hitTiming.elapsed(HIT_TIME))
        {
            hit.render(g);
        }
    }
}
